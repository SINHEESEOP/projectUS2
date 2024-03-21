
  $(".menu").on("click",(function(){
    
    $(this).toggleClass("active");


    $(".menu").each(function(){


      if($(this).hasClass("active")){
        $(this).next().css('display','block');
        $(this).css('backgroundColor','#344765');
        $(this).css('backgroundColor','#344765');
      }else{
        $(this).next().css('display','none');
        $(this).css('backgroundColor','#1b2536');
        $(this).parent().css('backgroundColor','#1b2536');
      }
    })
  }));
