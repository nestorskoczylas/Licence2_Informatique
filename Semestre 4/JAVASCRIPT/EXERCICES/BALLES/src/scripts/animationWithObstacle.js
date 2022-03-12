import Animation from './animation';

export default class AnimationWithObstacle extends Animation {

  constructor(canvas, obstacle) {
    super(canvas);
    this.obstacle = obstacle;
    this.left = 0;
    this.right = 0;
    this.down = 0;
    this.up = 0;
    this.drawn = 0;
  }

  drawObs() {
    if (this.drawn === 0) {this.drawn = 1;}
    else {this.drawn = 0;}
  }

  moveAndDrawBall() {
    if (this.drawn === 0) {
      this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
      this.balls.forEach(balle => {
        balle.move(this.canvas);
        balle.draw(this.context);
      });
      this.request = window.requestAnimationFrame(() => {this.moveAndDrawBall()});}
    else {
      let del = [];
      del[0] = null;
      this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
      this.obstacle.draw(this.context);
      this.balls.forEach((balle, i) => {
        balle.move(this.canvas);
        if (balle.collisionWith(this.obstacle)) {del[0] = i;}
        balle.draw(this.context);
      });
      if (del[0] !== null) {delete this.balls[del[0]];}
      this.obstacle.move(this.canvas);
      this.request = window.requestAnimationFrame(() => {this.moveAndDrawBall()});
    }
  }

  keyDownActionHandler(event) {
   switch (event.key) {
       case "ArrowLeft":
       case "Left":
           this.left = 1;
           if (this.up === 1) {
             this.obstacle.moveUpLeft();
             break
           }
           if (this.down === 1) {
             this.obstacle.moveDownLeft();
             break
           }
           this.obstacle.moveLeft();
           break;
       case "ArrowRight":
       case "Right":
           this.right = 1;
           if (this.up === 1) {
             this.obstacle.moveUpRight();
             break
           }
           if (this.down === 1) {
             this.obstacle.moveDownRight();
             break
           }
           this.obstacle.moveRight();
           break;
       case "ArrowUp":
       case "Up":
           this.up = 1;
           if (this.right === 1) {
             this.obstacle.moveUpRight();
             break;
           }
           if (this.left === 1) {
             this.obstacle.moveUpLeft();
             break;
           }
           this.obstacle.moveUp();
           break;
       case "ArrowDown":
       case "Down":
           this.down = 1;
           if (this.right === 1) {
             this.obstacle.moveDownRight();
             break;
           }
           if (this.left === 1) {
             this.obstacle.moveDownLeft();
             break;
           }
           this.obstacle.moveDown();
           break;
       default: return;
   }
   event.preventDefault();
 }

   keyUpActionHandler(event) {
      switch (event.key) {
          case "ArrowLeft":
          case "Left":
              this.left = 0;
              if (this.up === 1) {
                this.obstacle.moveUp();
                break;
              }
              if (this.down === 1) {
                this.obstacle.moveDown();
                break;
              }
              this.obstacle.stopMoving();
              break;
          case "ArrowRight":
          case "Right":
              this.right = 0;
              if (this.up === 1) {
                this.obstacle.moveUp();
                break;
              }
              if (this.down === 1) {
                this.obstacle.moveDown();
                break;
              }
              this.obstacle.stopMoving();
              break;
          case "ArrowUp":
          case "Up":
              this.up = 0;
              if (this.right === 1) {
                this.obstacle.moveRight();
                break;
              }
              if (this.left === 1) {
                this.obstacle.moveLeft();
                break;
              }
              this.obstacle.stopMoving();
              break;
          case "ArrowDown":
          case "Down":
              this.down = 0;
              if (this.right === 1) {
                this.obstacle.moveRight();
                break;
              }
              if (this.left === 1) {
                this.obstacle.moveLeft();
                break;
              }
              this.obstacle.stopMoving();
              break;
          default: return;
      }
      event.preventDefault();
  }

}
