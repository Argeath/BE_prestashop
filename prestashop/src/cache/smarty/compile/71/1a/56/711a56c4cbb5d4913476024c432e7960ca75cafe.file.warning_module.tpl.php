<?php /* Smarty version Smarty-3.1.19, created on 2017-11-29 14:53:17
         compiled from "/var/www/html/admin0671bdkcq/themes/default/template/controllers/modules/warning_module.tpl" */ ?>
<?php /*%%SmartyHeaderCode:21068612825a0036f608ba78-34647562%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '711a56c4cbb5d4913476024c432e7960ca75cafe' => 
    array (
      0 => '/var/www/html/admin0671bdkcq/themes/default/template/controllers/modules/warning_module.tpl',
      1 => 1511962724,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '21068612825a0036f608ba78-34647562',
  'function' => 
  array (
  ),
  'version' => 'Smarty-3.1.19',
  'unifunc' => 'content_5a0036f6095612_81755402',
  'variables' => 
  array (
    'module_link' => 0,
    'text' => 0,
  ),
  'has_nocache_code' => false,
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_5a0036f6095612_81755402')) {function content_5a0036f6095612_81755402($_smarty_tpl) {?>
<a href="<?php echo htmlspecialchars($_smarty_tpl->tpl_vars['module_link']->value, ENT_QUOTES, 'UTF-8', true);?>
"><?php echo $_smarty_tpl->tpl_vars['text']->value;?>
</a><?php }} ?>
