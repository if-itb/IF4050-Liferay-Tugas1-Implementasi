<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<portlet:defineObjects />

This is the <b>Social</b> portlet in View mode.
<div>
	<textarea class="form-control" rows="3" id="message"></textarea>
	<button type="button" class="btn btn-default" id="submit">Submit</button>
</div>

<script>
$(function() {
    $('#submit').click(function() {
        $('#view').append($('#message').html());
    });
});
    
</script>
