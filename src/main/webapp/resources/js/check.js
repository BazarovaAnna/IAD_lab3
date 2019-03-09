function validation() {

}

function interract(){

}

function draw(canv) {
    let ctx = document.getElementById(canv).getContext("2d");

    ctx.clearRect(0, 0, 400, 400);
//четверть круга
    ctx.beginPath();
    ctx.moveTo(200, 200);
    ctx.arc(200, 200, 140, 2 * Math.PI,  3*Math.PI/2, true);
    ctx.closePath();
    ctx.strokeStyle = "dodgerblue";
    ctx.fillStyle = "dodgerblue";
    ctx.fill();
    ctx.stroke();
//квадрат
    ctx.beginPath();
    ctx.rect(60, 60, 140, 140);
    ctx.closePath();
    ctx.strokeStyle = "dodgerblue";
    ctx.fillStyle = "dodgerblue";
    ctx.fill();
    ctx.stroke();
//треугольник
    ctx.beginPath();
    ctx.moveTo(200, 200);
    ctx.lineTo(270, 200);
    ctx.lineTo(200, 270);
    ctx.lineTo(200, 200);
    ctx.closePath();
    ctx.strokeStyle = "dodgerblue";
    ctx.fillStyle = "dodgerblue";
    ctx.fill();
    ctx.stroke();
//ось ОУ
    ctx.beginPath();
    ctx.moveTo(200, 380);
    ctx.lineTo(200, 20);
    ctx.lineTo(195, 25);
    ctx.lineTo(205, 25);
    ctx.lineTo(200, 20);
    ctx.closePath();
    ctx.strokeStyle = "black";
    ctx.fillStyle = "black";
    ctx.fill();
    ctx.stroke();
//ось ОХ
    ctx.beginPath();
    ctx.moveTo(20, 200);
    ctx.lineTo(380, 200);
    ctx.lineTo(375, 195);
    ctx.lineTo(375, 205);
    ctx.lineTo(380, 200);
    ctx.closePath();
    ctx.strokeStyle = "black";
    ctx.fillStyle = "black";
    ctx.fill();
    ctx.stroke();
//отметки на осях
    ctx.beginPath();

    ctx.moveTo(270, 195);
    ctx.lineTo(270, 205);
    ctx.moveTo(340, 195);
    ctx.lineTo(340, 205);

    ctx.moveTo(195, 130);
    ctx.lineTo(205, 130);
    ctx.moveTo(195, 60);
    ctx.lineTo(205, 60);

    ctx.moveTo(130, 195);
    ctx.lineTo(130, 205);
    ctx.moveTo(60, 195);
    ctx.lineTo(60, 205);

    ctx.moveTo(195, 270);
    ctx.lineTo(205, 270);
    ctx.moveTo(195, 340);
    ctx.lineTo(205, 340);

    ctx.closePath();
    ctx.strokeStyle = "black";
    ctx.fillStyle = "black";
    ctx.stroke();

    ctx.font = "20px Times New Roman";
    ctx.fillText('Y', 210, 30);
    ctx.fillText('X', 370, 225);
}



window.onkeydown = function (e) {
    let code = e.key;
    if (code === 'Enter') {
        validation();
    }
};

function getMousePos(canvas, evt) {
    let rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}




function drawPoint(canv, x, y, r) {
    let ctx = document.getElementById(canv).getContext("2d");
    ctx.beginPath();
    ctx.font = "14px Times New Roman";
    ctx.fillText(r, 340, 215);
    ctx.fillText(r / 2, 270, 215);

    ctx.fillText(r, 215, 60);
    ctx.fillText(r / 2, 215, 130);

    ctx.fillText(-r, 60, 215);
    ctx.fillText(-(r / 2), 130, 215);

    ctx.fillText(-r, 215, 340);
    ctx.fillText(-(r / 2), 215, 275);

    ctx.closePath();//this
    ctx.strokeStyle = "black";//part
    ctx.fillStyle = "black";//delete
    ctx.stroke();//to have dif colors with this code nothing was checked

    if (r < 1 || r > 4) {
    }
    else {
        if (Math.abs(x / r) > 1.2 || Math.abs(y / r) > 1.2) {
            ctx.font = "14px Times New Roman";
            ctx.fillText('Some of points are out of the graph', 130, 390);
        } else {
            ctx.beginPath();
            ctx.arc(Math.round(200 + ((x / r) * 140)), Math.round(200 - ((y / r) * 140)), 3, 0, Math.PI * 2);
            ctx.closePath();
            if (    (x >= 0 && y >= 0 && (x*x+y*y)<=r*r) ||
                (x <= 0 && y >= 0 && Math.abs(x)<=(r/2) && y<=r) ||
                (x <= 0 && y <= 0 && y>=-x-r)
            ){//костыль для зеленых точек
                ctx.strokeStyle = "green";
                ctx.fillStyle = "green";
                ctx.fill();
                ctx.stroke();
            }else{
                ctx.strokeStyle = "red";
                ctx.fillStyle = "red";
                ctx.fill();
                ctx.stroke();
            }
        }
    }
}
