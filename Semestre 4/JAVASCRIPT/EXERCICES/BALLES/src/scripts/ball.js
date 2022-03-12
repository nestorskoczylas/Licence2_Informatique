
// la source de l'image à utiliser pour la balle
import ballImgSrc from './assets/images/ball.png';

/* TYPE Ball */
export default class Ball {

  static BALL_WIDTH = 48;

  constructor(x, y, dx, dy){
    this.x = x;
    this.y = y;
    this.deltaX = dx;
    this.deltaY = dy;
    this.image = this.createImage();
  }

  draw(context) {
	   context.drawImage(this.image, this.x, this.y);
  }

  move(canvas){
    if(this.x + this.deltaX < 0 ||
      this.x + this.deltaX > canvas.width - Ball.BALL_WIDTH){
      this.deltaX = -this.deltaX;
    }
    if(this.y + this.deltaY < 0 ||
      this.y + this.deltaY > canvas.height - Ball.BALL_WIDTH){
      this.deltaY = -this.deltaY;
    }
    this.x += this.deltaX;
    this.y += this.deltaY;
  }

  /* crée l'objet Image à utiliser pour dessiner cette balle */
  createImage() {
    const ballImg = new Image();
  	ballImg.width = Ball.BALL_WIDTH;
  	ballImg.src = ballImgSrc;
  	return ballImg;
  }

  collisionWith(obstacle) {
    let b2x = obstacle.x + obstacle.w;
    let b2y = obstacle.y + obstacle.h;

    let p1x = Math.max(this.x, obstacle.x);
    let p1y = Math.max(this.y, obstacle.y);

    let p2x = Math.min(this.x + Ball.BALL_WIDTH, b2x);
    let p2y = Math.min(this.y + Ball.BALL_WIDTH, b2y);

    return ((p1x < p2x) && (p1y < p2y));
  }
}
