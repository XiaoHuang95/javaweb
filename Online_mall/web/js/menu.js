if (navigator.appName=="Microsoft Internet Explorer") {
    function fPmVerticalRightOut() {
        var getItem = document.getElementById("pmVerticalRightOut").getElementsByTagName("div");
        for (var i=0; i<getItem.length; i++) {
            getItem[i].οnmοuseοver=function() {
                if(     this.className=="level"){
                    this.className="levelIe";
                }
            }
            getItem[i].οnmοuseοut=function() {
                if(     this.className=="levelIe"){
                    this.className="level";
                }
            }//css popup menu script by shawl.qiu
        }
    }
    window.οnlοad=fPmVerticalRightOut;
}
