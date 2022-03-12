export default class Mobile {

  constructor(x, y, src, deltaX = 0, deltaY = 0){
    this.x = x;
    this.y = y;
    this.src = src;
    this.image = this.createImage();
    this.deltaX = deltaX;
    this.deltaY = deltaY;
  }

  createImage() {
    const img = new Image();
    img.src = this.src;
    return img;
  }

  draw(context) {
    context.drawImage(this.image, this.x, this.y);
  }

  move(canvas) {
    this.x += this.deltaX;
    this.y += this.deltaY;
  }

}
