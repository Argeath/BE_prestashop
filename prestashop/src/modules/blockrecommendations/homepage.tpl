{if count($products) > 0}
    {if $page_name == 'product'}
        <h3>Zobacz również:</h3>
    {else}
        <h3>Rekomendacje dla Ciebie:</h3>
    {/if}
    <div id="recommendation-block" class="recommendation-block">
        {foreach $products as $product}
            <div class="recommendation-item">
                <a class="product_img_link" href="{$link->getProductLink($product->id, $product->link_rewrite, $product->category_link_rewrite)|escape:'html':'UTF-8'}" title="{$product->name|escape:'html':'UTF-8'}" itemprop="url">
                    <img class="replace-2x img-responsive" src="{$link->getImageLink($product->link_rewrite, $product->id_image, 'home_default')|escape:'html':'UTF-8'}" alt="{if !empty($product->legend)}{$product->legend|escape:'html':'UTF-8'}{else}{$product->name|escape:'html':'UTF-8'}{/if}" title="{if !empty($product->legend)}{$product->legend|escape:'html':'UTF-8'}{else}{$product->name|escape:'html':'UTF-8'}{/if}" itemprop="image" />
                </a>
                <div class="recommendation-title">
                    <h5 itemprop="name">
                        <a class="product_img_link" href="{$link->getProductLink($product->id, $product->link_rewrite, $product->category_link_rewrite)|escape:'html':'UTF-8'}" title="{$product->name|escape:'html':'UTF-8'}" itemprop="url">
                            {$product->name|escape:'html':'UTF-8'}
                        </a>
                    </h5>
                </div>
                <div class="content_price">
                    {if isset($product->show_price) && $product->show_price && !isset($restricted_country_mode)}
                        {hook h="displayProductPriceBlock" product=$product type='before_price'}
                        <span class="price product-price">
								{if !$priceDisplay}{convertPrice price=$product->price}{else}{convertPrice price=$product->price_tax_exc}{/if}
							</span>
                        {if $product->price_without_reduction > 0 && isset($product->specific_prices) && $product->specific_prices && isset($product->specific_prices.reduction) && $product->specific_prices.reduction > 0}
                            {hook h="displayProductPriceBlock" product=$product type="old_price"}
                            <span class="old-price product-price">
									{displayWtPrice p=$product->price_without_reduction}
								</span>
                            {hook h="displayProductPriceBlock" id_product=$product->id_product type="old_price"}
                            {if $product->specific_prices.reduction_type == 'percentage'}
                                <span class="price-percent-reduction">-{$product->specific_prices.reduction * 100}%</span>
                            {/if}
                        {/if}
                        {hook h="displayProductPriceBlock" product=$product type="price"}
                        {hook h="displayProductPriceBlock" product=$product type="unit_price"}
                        {hook h="displayProductPriceBlock" product=$product type='after_price'}
                    {/if}
                </div>
            </div>
        {/foreach}
    </div>
{/if}