<?php /* Smarty version Smarty-3.1.19, created on 2017-11-06 10:40:28
         compiled from "/var/www/html/admin0671bdkcq/themes/default/template/content.tpl" */ ?>
<?php /*%%SmartyHeaderCode:8985632205a002e0cc5c804-58443171%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    'e97051ab377c17844bdab8b43448722159d90b0b' => 
    array (
      0 => '/var/www/html/admin0671bdkcq/themes/default/template/content.tpl',
      1 => 1504515462,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '8985632205a002e0cc5c804-58443171',
  'function' => 
  array (
  ),
  'variables' => 
  array (
    'content' => 0,
  ),
  'has_nocache_code' => false,
  'version' => 'Smarty-3.1.19',
  'unifunc' => 'content_5a002e0cc63720_72444990',
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_5a002e0cc63720_72444990')) {function content_5a002e0cc63720_72444990($_smarty_tpl) {?>
<div id="ajax_confirmation" class="alert alert-success hide"></div>

<div id="ajaxBox" style="display:none"></div>


<div class="row">
	<div class="col-lg-12">
		<?php if (isset($_smarty_tpl->tpl_vars['content']->value)) {?>
			<?php echo $_smarty_tpl->tpl_vars['content']->value;?>

		<?php }?>
	</div>
</div><?php }} ?>
