window.onload = initPage;

function initPage() {
    //finds the thumbnails on the page
    thumbs = document.getElementById("thumbnailPane").getElementsByTagName("IMG");
    
    //set the handler for each image
    for(var i = 0; i < thumbs.length; i++) {
        image = thumbs[i];
        
        //create onclick function
        image.onclick = function() {
            //find the full size image name
            detailURL = 'images/' + this.title + '-detail.jpg';
            document.getElementById("itemDetail").src = detailURL;
            getDetails(this.title);
        }
    }
}

function getDetails (itemName) {
    request = createRequest();

    if(request == null) {
        alert("Unable to create request");
        return;
    }

    var url = "getDetails.php?ImageID="+ encodeURIComponent(itemName);
    request.open("GET",url,true);
    request.onreadystatechange = displayDetails;
    request.send(null);
}

function createRequest() {
    try {
        request = new XMLHttpRequest();
    } catch (tryMS){
        try {
            request = new ActiveXObject("Msxml12.XMLHTTP");
        } catch (otherMS) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = null;
            }
        }
    }

    return request;
}