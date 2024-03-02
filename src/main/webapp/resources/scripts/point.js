var pointList;
var canvas = document.querySelector('#svg');
var canWid = canvas === null || canvas === void 0 ? void 0 : canvas.getBoundingClientRect().width;
var drawPoint = function (cX, cY, cHit) {
    var circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
    circle.setAttribute("cx", "0");
    circle.setAttribute("cy", "0");
    circle.setAttribute("stroke", cHit ? "#00ff00" : "#ff0000");
    circle.setAttribute("r", "5px");
    canvas === null || canvas === void 0 ? void 0 : canvas.appendChild(circle);
};
var drawAll = function () {
    pointList.forEach(function (p) { drawPoint(p.x, p.y, p.hit); });
};
var fillList = function (data) {
    pointList = JSON.parse(data);
    console.log(pointList);
};
if (canvas) {
    canvas.onmousedown = function (e) {
        console.log('CLICK');
        var x = e.offsetX;
        var y = e.offsetY;
        // @ts-ignore
        addPoint([
            { name: "x", value: x.toString() },
            { name: "y", value: y.toString() }
        ]);
    };
}
