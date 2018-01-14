<?php

if (!defined('_PS_VERSION_'))
    exit;

class BlockRecommendations extends Module
{
    public function __construct()
    {
        $this->name = "blockrecommendations";
        $this->tab = "front_office_features";
        $this->version = "1.0";
        $this->author = "DKinal";

        $this->need_instance = 0;

        $this->bootstrap = true;
        parent::__construct();

        $this->displayName = $this->l('Recommendations block');
        $this->description = $this->l('Displays recommended products.');
        $this->ps_versions_compliancy = array('min' => '1.6', 'max' => '1.6.99.99');
    }

    public function install() {
        if(
            !parent::install() or
            !$this->registerHook('displayUserRecommendedProducts') or
            !$this->registerHook('displaySearchRecommendedProducts') or
            !$this->registerHook('displayHeader')
        )
            return false;
        return true;
    }

    public function hookDisplayUserRecommendedProducts($params) {
        $items = json_decode(Tools::file_get_contents("http://recommendations:8080/recommendForUser/{$this->context->customer->id}"));

        $products = $this->prepareProducts($items);

        $this->smarty->assign(array(
            'products' => $products,
        ));

        return $this->display(__FILE__, 'homepage.tpl');
    }

    public function hookDisplayHeader($params)
    {
        $this->context->controller->addCSS($this->_path.'blockrecommendations.css', 'all');
    }

    public function hookDisplaySearchRecommendedProducts($params) {
        if(!$params['products'])
            return "";

        $ids = [];
        if(is_array($params['products'])) {
            foreach ($params['products'] as $product) {
                $ids[] = $product['id_product'];
            }
        } else {
            $ids[] = $params['products']->id;
        }

        $idsJoined = implode(",", $ids);

        $items = json_decode(Tools::file_get_contents("http://recommendations:8080/recommendForItems/{$idsJoined}/{$params['amount']}"));

        $products = $this->prepareProducts($items);

        $this->smarty->assign(array(
            'products' => $products,
        ));

        return $this->display(__FILE__, 'homepage.tpl');
    }

    private function prepareProducts($items) {
        $products = [];
        $id_lang = (int)Context::getContext()->language->id;

        foreach ($items as $item) {
            $id_product = $item->itemID;
            $image = Image::getCover($id_product);
            $product = new Product($id_product, false, $id_lang);
            $product->id_image = $image['id_image'];
            $category = Category::getLinkRewrite((int)$product->id_category_default, $id_lang);
            $product->category_link_rewrite = $category->link_rewrite;
            $product->price *= 1.23;
            $products[] = $product;
        }

        return $products;
    }
}