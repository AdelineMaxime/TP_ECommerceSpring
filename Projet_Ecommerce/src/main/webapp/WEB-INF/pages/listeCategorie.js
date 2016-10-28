var list = document.getElementById("categorieDrop"); 
for (var i = 0; i < rows; i++){                
    var opt = table.getValue(i, 0);  
    var li = document.createElement("li");
    var text = document.createTextNode(opt);
    text.href = "#";
    li.appendChild(text);
    // alert("option " + opt); 
    list.appendChild(li);
  }