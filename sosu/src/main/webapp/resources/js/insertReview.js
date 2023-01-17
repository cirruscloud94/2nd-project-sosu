$(function() {
    function check() 
    {
        let contents = document.querySelector("#rv_content").value; //내용
        let Category = $('#rate1');
    
        if (contents == "" || contents == null) 
        {
            alert("리뷰를 작성해주세요.");
            return false;
        }
    
        if($(':radio[name="rv_star"]:checked').length < 1)
        {
            alert('별점을 선택해주세요.');						
            
            return false;
        }
    }	  
});