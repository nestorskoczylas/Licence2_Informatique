import Ball from './ball';

/* TYPE Animation */
export default class Animation {

  constructor(canvas){
    this.canvas = canvas;
    this.balls = [];
    this.context = canvas.getContext('2d');
    this.request = null;
  }

  addBall(){
    let nb1 = Math.random()*5-5;
    let nb2 = Math.random()*5-5;
    while (nb1 === 0 && nb2 === 0) {nb1 = Math.random()*5-5;}
    let x = Math.floor(Math.random()*(this.canvas.width - Ball.BALL_WIDTH));
    let y = Math.floor(Math.random()*(this.canvas.height - Ball.BALL_WIDTH));
    this.balls.push(new Ball(x, y, nb1, nb2));
  }

  moveAndDrawBall(){
    this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    this.balls.forEach(balle => {
      balle.move(this.canvas);
      balle.draw(this.context);
    });
    this.request = window.requestAnimationFrame(() => {this.moveAndDrawBall()});
  }

  /* start the animation or stop it if previously running */
  startAndStop() {
    if(this.request === null){
      this.request = window.requestAnimationFrame(() => {this.moveAndDrawBall()});
    }

    else{
      window.cancelAnimationFrame(this.request);
      this.request = null;
    }
  }
}
