function inicio() {
    document.getElementById('azul').addEventListener('onclick', displayoff, false);
}


function displayon() {
    
    document.getElementById("section-post-cmnt").style.display = "block";
    document.getElementById('section-pts').style.display = "none";
    
}

function displayoff() {
    document.getElementById('section-pts').style.display = "block";
    document.getElementById("section-post-cmnt").style.display = "none";

}