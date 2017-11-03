<?php /* Smarty version Smarty-3.1.19, created on 2017-11-03 21:38:17
         compiled from "/var/www/html/admin/themes/default/template/controllers/modules/warning_module.tpl" */ ?>
<?php /*%%SmartyHeaderCode:31520229159fce1c9bf65c9-52485587%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '46000c9ff1470fe45366962f5ea9ebbb5c36ad5b' => 
    array (
      0 => '/var/www/html/admin/themes/default/template/controllers/modules/warning_module.tpl',
      1 => 1504515462,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '31520229159fce1c9bf65c9-52485587',
  'function' => 
  array (
  ),
  'variables' => 
  array (
    'module_link' => 0,
    'text' => 0,
  ),
  'has_nocache_code' => false,
  'version' => 'Smarty-3.1.19',
  'unifunc' => 'content_59fce1c9bfb5b8_25233915',
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_59fce1c9bfb5b8_25233915')) {function content_59fce1c9bfb5b8_25233915($_smarty_tpl) {?>
<a href="<?php echo htmlspecialchars($_smarty_tpl->tpl_vars['module_link']->value, ENT_QUOTES, 'UTF-8', true);?>
"><?php echo $_smarty_tpl->tpl_vars['text']->value;?>
</a><?php }} ?>
