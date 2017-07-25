<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<c:set var="ctx" value="${pageContext.request.contextPath}"/>




<!-- / jquery -->
<script src='${ctx}/newJsp/assets/javascripts/jquery/jquery.min.js' type='text/javascript'></script>
<!-- / jquery mobile events (for touch and slide) -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/mobile_events/jquery.mobile-events.min.js' type='text/javascript'></script>
<!-- / jquery migrate (for compatibility with new jquery) -->
<script src='${ctx}/newJsp/assets/javascripts/jquery/jquery-migrate.min.js' type='text/javascript'></script>
<!-- / jquery ui -->
<script src='${ctx}/newJsp/assets/javascripts/jquery_ui/jquery-ui.min.js' type='text/javascript'></script>
<!-- / bootstrap -->
<script src='${ctx}/newJsp/assets/javascripts/bootstrap/bootstrap.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/flot/excanvas.js' type='text/javascript'></script>
<!-- / sparklines -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/sparklines/jquery.sparkline.min.js' type='text/javascript'></script>
<!-- / flot charts -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/flot/flot.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/flot/flot.resize.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/flot/flot.pie.js' type='text/javascript'></script>
<!-- / bootstrap switch -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootstrap_switch/bootstrapSwitch.min.js' type='text/javascript'></script>
<!-- / fullcalendar -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/fullcalendar/fullcalendar.min.js' type='text/javascript'></script>
<!-- / datatables -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/datatables/jquery.dataTables.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/datatables/jquery.dataTables.columnFilter.js' type='text/javascript'></script>
<!-- / wysihtml5 -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/common/wysihtml5.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/common/bootstrap-wysihtml5.js' type='text/javascript'></script>
<!-- / select2 -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/select2/select2.js' type='text/javascript'></script>
<!-- / color picker -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootstrap_colorpicker/bootstrap-colorpicker.min.js' type='text/javascript'></script>
<!-- / mention -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/mention/mention.min.js' type='text/javascript'></script>
<!-- / input mask -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/input_mask/bootstrap-inputmask.min.js' type='text/javascript'></script>
<!-- / fileinput -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileinput/bootstrap-fileinput.js' type='text/javascript'></script>
<!-- / modernizr -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/modernizr/modernizr.min.js' type='text/javascript'></script>
<!-- / retina -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/retina/retina.js' type='text/javascript'></script>
<!-- / fileupload -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/tmpl.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/load-image.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/canvas-to-blob.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/jquery.iframe-transport.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/jquery.fileupload.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/jquery.fileupload-fp.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/jquery.fileupload-ui.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/fileupload/jquery.fileupload-init.js' type='text/javascript'></script>
<!-- / timeago -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/timeago/jquery.timeago.js' type='text/javascript'></script>
<!-- / slimscroll -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/slimscroll/jquery.slimscroll.min.js' type='text/javascript'></script>
<!-- / autosize (for textareas) -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/autosize/jquery.autosize-min.js' type='text/javascript'></script>
<!-- / charCount -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/charCount/charCount.js' type='text/javascript'></script>
<!-- / validate -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/validate/jquery.validate.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/validate/additional-methods.js' type='text/javascript'></script>
<!-- / naked password -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/naked_password/naked_password-0.2.4.min.js' type='text/javascript'></script>
<!-- / nestable -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/nestable/jquery.nestable.js' type='text/javascript'></script>
<!-- / tabdrop -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/tabdrop/bootstrap-tabdrop.js' type='text/javascript'></script>
<!-- / jgrowl -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/jgrowl/jquery.jgrowl.min.js' type='text/javascript'></script>
<!-- / bootbox -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootbox/bootbox.min.js' type='text/javascript'></script>
<!-- / inplace editing -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/xeditable/bootstrap-editable.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/xeditable/wysihtml5.js' type='text/javascript'></script>
<!-- / ckeditor -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/ckeditor/ckeditor.js' type='text/javascript'></script>
<!-- / filetrees -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/dynatree/jquery.dynatree.min.js' type='text/javascript'></script>
<!-- / datetime picker -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootstrap_datetimepicker/bootstrap-datetimepicker.js' type='text/javascript'></script>
<!-- / daterange picker -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootstrap_daterangepicker/moment.min.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootstrap_daterangepicker/bootstrap-daterangepicker.js' type='text/javascript'></script>
<!-- / max length -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootstrap_maxlength/bootstrap-maxlength.min.js' type='text/javascript'></script>
<!-- / dropdown hover -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/bootstrap_hover_dropdown/twitter-bootstrap-hover-dropdown.min.js' type='text/javascript'></script>
<!-- / slider nav (address book) -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/slider_nav/slidernav-min.js' type='text/javascript'></script>
<!-- / fuelux -->
<script src='${ctx}/newJsp/assets/javascripts/plugins/fuelux/wizard.js' type='text/javascript'></script>
<!-- / flatty theme -->
<script src='${ctx}/newJsp/assets/javascripts/nav.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/tables.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/theme.js' type='text/javascript'></script>
<!-- / demo -->
<script src='${ctx}/newJsp/assets/javascripts/demo/jquery.mockjax.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/demo/inplace_editing.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/demo/charts.js' type='text/javascript'></script>
<script src='${ctx}/newJsp/assets/javascripts/demo/demo.js' type='text/javascript'></script>

<link href='${ctx}/newJsp/assets/stylesheets/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
<link href='${ctx}/newJsp/assets/stylesheets/bootstrap/bootstrap-responsive.css' media='all' rel='stylesheet' type='text/css' />
<!-- / jquery ui -->
<link href='${ctx}/newJsp/assets/stylesheets/jquery_ui/jquery-ui-1.10.0.custom.css' media='all' rel='stylesheet' type='text/css' />
<link href='${ctx}/newJsp/assets/stylesheets/jquery_ui/jquery.ui.1.10.0.ie.css' media='all' rel='stylesheet' type='text/css' />
<!-- / switch buttons -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/bootstrap_switch/bootstrap-switch.css' media='all' rel='stylesheet' type='text/css' />
<!-- / xeditable -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/xeditable/bootstrap-editable.css' media='all' rel='stylesheet' type='text/css' />
<link href='${ctx}/newJsp/assets/stylesheets/plugins/common/bootstrap-wysihtml5.css' media='all' rel='stylesheet' type='text/css' />
<!-- / wysihtml5 (wysywig) -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/common/bootstrap-wysihtml5.css' media='all' rel='stylesheet' type='text/css' />
<!-- / jquery file upload -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/jquery_fileupload/jquery.fileupload-ui.css' media='all' rel='stylesheet' type='text/css' />
<!-- / full calendar -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/fullcalendar/fullcalendar.css' media='all' rel='stylesheet' type='text/css' />
<!-- / select2 -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/select2/select2.css' media='all' rel='stylesheet' type='text/css' />
<!-- / mention -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/mention/mention.css' media='all' rel='stylesheet' type='text/css' />
<!-- / tabdrop (responsive tabs) -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/tabdrop/tabdrop.css' media='all' rel='stylesheet' type='text/css' />
<!-- / jgrowl notifications -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/jgrowl/jquery.jgrowl.min.css' media='all' rel='stylesheet' type='text/css' />
<!-- / datatables -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/datatables/bootstrap-datatable.css' media='all' rel='stylesheet' type='text/css' />
<!-- / dynatrees (file trees) -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/dynatree/ui.dynatree.css' media='all' rel='stylesheet' type='text/css' />
<!-- / color picker -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/bootstrap_colorpicker/bootstrap-colorpicker.css' media='all' rel='stylesheet' type='text/css' />
<!-- / datetime picker -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/bootstrap_datetimepicker/bootstrap-datetimepicker.min.css' media='all' rel='stylesheet' type='text/css' />
<!-- / daterange picker) -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/bootstrap_daterangepicker/bootstrap-daterangepicker.css' media='all' rel='stylesheet' type='text/css' />
<!-- / flags (country flags) -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/flags/flags.css' media='all' rel='stylesheet' type='text/css' />
<!-- / slider nav (address book) -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/slider_nav/slidernav.css' media='all' rel='stylesheet' type='text/css' />
<!-- / fuelux (wizard) -->
<link href='${ctx}/newJsp/assets/stylesheets/plugins/fuelux/wizard.css' media='all' rel='stylesheet' type='text/css' />
<!-- / flatty theme -->
<link href='${ctx}/newJsp/assets/stylesheets/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
<!-- / demo -->
<link href='${ctx}/newJsp/assets/stylesheets/demo.css' media='all' rel='stylesheet' type='text/css' />