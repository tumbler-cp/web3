interface Point {
    x: number,
    y: number,
    r: number,
    hit: boolean
}

let pointList: Point[];

const canvas: HTMLElement | null = document.querySelector('#svg');
const canWid: number | undefined = canvas?.getBoundingClientRect().width;

const drawPoint = (cX: number, cY:number, cHit:boolean) => {
    let circle = document.createElementNS("http://www.w3.org/2000/svg","circle");
    circle.setAttribute("cx", "0");
    circle.setAttribute("cy", "0");
    circle.setAttribute("stroke", cHit ? "#00ff00" : "#ff0000");
    circle.setAttribute("r", "5px");
    canvas?.appendChild(circle);
}

const drawAll = () => {
    pointList.forEach((p) => {drawPoint(p.x, p.y, p.hit);});
}

const fillList = (data: string) => {
    pointList = JSON.parse(data);
    console.log(pointList);
}

if (canvas) {
    canvas.onmousedown = (e) => {
        console.log('CLICK');
        const x = e.offsetX;
        const y = e.offsetY;
        // @ts-ignore
        addPoint([
            { name: "x", value: x.toString() },
            { name: "y", value: y.toString() }
        ]);
    }
}