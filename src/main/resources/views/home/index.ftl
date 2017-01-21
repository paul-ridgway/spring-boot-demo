<@page_title title="Page Title Set in View"/>

<p>
    Controller Value Test: ${test}
</p>
<p>
    JQuery Test: <span id="jquery-test">Failed</span>
</p>
<script language="javascript">
    $(document).ready(function() {
        $('#jquery-test').html("This value was set by JQuery!!");
    });
</script>
