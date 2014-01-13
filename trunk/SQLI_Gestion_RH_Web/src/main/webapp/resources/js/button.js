$(function() {
    $( "input[type=submit], input[type=button]" )
      .button()
      .click(function( event ) {
        event.preventDefault();
      });
  });