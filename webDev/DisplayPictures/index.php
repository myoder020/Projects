<?php
session_start();
include("nav.html");
include("getDir.php");
$dirs = $_SESSION['dirs'];
?>

<script type="text/javascript">
var parr = '<?php echo $dirs ?>';
document.write(parr[0]);
;</script>