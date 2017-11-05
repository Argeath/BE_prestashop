<?php /* Smarty version Smarty-3.1.19, created on 2017-11-05 22:29:25
         compiled from "/var/www/html/admin0671bdkcq/themes/default/template/content.tpl" */ ?>
<?php /*%%SmartyHeaderCode:44886733659fce3e400eff5-09790160%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    'e97051ab377c17844bdab8b43448722159d90b0b' => 
    array (
      0 => '/var/www/html/admin0671bdkcq/themes/default/template/content.tpl',
      1 => 1509916534,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '44886733659fce3e400eff5-09790160',
  'function' => 
  array (
  ),
  'version' => 'Smarty-3.1.19',
  'unifunc' => 'content_59fce3e4014572_10429545',
  'variables' => 
  array (
    'content' => 0,
  ),
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_59fce3e4014572_10429545')) {function content_59fce3e4014572_10429545($_smarty_tpl) {?>
<div id="ajax_confirmation" class="alert alert-success hide"></div>

<div id="ajaxBox" style="display:none"></div>


<div class="row">
	<div class="col-lg-12">
		<?php if (isset($_smarty_tpl->tpl_vars['content']->value)) {?>
			<?php echo $_smarty_tpl->tpl_vars['content']->value;?>

		<?php }?>
	</div>
</div><?php }} ?>
