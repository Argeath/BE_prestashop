<?php /* Smarty version Smarty-3.1.19, created on 2017-11-03 21:38:21
         compiled from "/var/www/html/admin/themes/default/template/helpers/tree/tree_node_item.tpl" */ ?>
<?php /*%%SmartyHeaderCode:195625813859fce1cdd7dd32-48105746%%*/if(!defined('SMARTY_DIR')) exit('no direct access allowed');
$_valid = $_smarty_tpl->decodeProperties(array (
  'file_dependency' => 
  array (
    '911ae27a96e8bad21250ce15324f7b91fa313bbc' => 
    array (
      0 => '/var/www/html/admin/themes/default/template/helpers/tree/tree_node_item.tpl',
      1 => 1504515462,
      2 => 'file',
    ),
  ),
  'nocache_hash' => '195625813859fce1cdd7dd32-48105746',
  'function' => 
  array (
  ),
  'variables' => 
  array (
    'node' => 0,
  ),
  'has_nocache_code' => false,
  'version' => 'Smarty-3.1.19',
  'unifunc' => 'content_59fce1cdd80bc1_48897569',
),false); /*/%%SmartyHeaderCode%%*/?>
<?php if ($_valid && !is_callable('content_59fce1cdd80bc1_48897569')) {function content_59fce1cdd80bc1_48897569($_smarty_tpl) {?>

<li class="tree-item">
	<span class="tree-item-name">
		<i class="tree-dot"></i>
		<label class="tree-toggler"><?php echo $_smarty_tpl->tpl_vars['node']->value['name'];?>
</label>
	</span>
</li><?php }} ?>
