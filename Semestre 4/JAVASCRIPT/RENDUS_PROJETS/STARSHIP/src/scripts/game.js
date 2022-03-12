import StarShip from './starship';
import Saucer from './saucer';
import SaucerFalling from './saucerfalling';
import Shoot from './shoot';

export default class Game {

  constructor(canvas) {
    this.canvas = canvas;
    this.context = canvas.getContext('2d');
    this.request = null;
    this.ship = new StarShip(40, this.canvas.height/2);
    this.saucers = [];
    this.shoots = [];
    this.fallings = [];
    this.score = 0;
    this.infinit = -1;
    this.interval;
  }

  infinity() {
    this.infinit = -this.infinit;
    if (this.infinit === 1) {this.interval = setInterval(() => {this.addSaucer()}, 750);}
    else {this.interval = clearInterval(this.interval);}
    document.getElementById("flotteSoucoupes").blur();
  }

  addSaucer() {
    let y = Math.floor(Math.random()*(this.canvas.height - Saucer.SAUCER_HEIGHT));
    this.saucers.push(new Saucer(this.canvas.width, y));
    document.getElementById("addSaucer").blur();
  }

  addShoot() {
    this.shoots.push(new Shoot (79 , this.ship.y + 12));
  }

  addSaucerFalling(x, y) {
    this.fallings.push(new SaucerFalling(x, y))
  }

  moveAndDraw() {
    this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    this.ship.draw(this.context);
    this.moveAndDrawShoots();
    this.moveAndDrawSaucers();
    this.moveAndDrawSaucersFalling();
    this.shoots = this.shoots.filter(shoot => shoot.deleted !== true);
    this.saucers = this.saucers.filter(saucer => saucer.deleted !== true);
    this.fallings = this.fallings.filter(saucer => saucer.deleted !== true);
    this.ship.move(this.canvas);
    this.request = window.requestAnimationFrame(() => {this.moveAndDraw()});
  }

  moveAndDrawShoots() {
    this.shoots.forEach((shoot) => {
      shoot.saucers = this.saucers;
      shoot.move(this.canvas);
      if (shoot.destroySaucer()) {this.addScore();}
      shoot.draw(this.context);
    })
  }

  moveAndDrawSaucers() {
    this.saucers.forEach((saucer) => {
      saucer.move(this.canvas);
      if (saucer.fall) {this.addSaucerFalling(saucer.x, saucer.y)}
      if (saucer.deleted && !saucer.fall) {this.addScore(-1000);}
      saucer.draw(this.context);
    })
  }

  moveAndDrawSaucersFalling() {
    this.fallings.forEach((saucer, i) => {
      saucer.move(this.canvas);
      saucer.draw(this.context);
    })
  }

  addScore(added = 200) {
    this.score += added;
    document.getElementById("score").textContent = this.score;
  }

  startAndStop() {
    if(this.request === null){
      this.request = window.requestAnimationFrame(() => {this.moveAndDraw()});
    }

    else{
      window.cancelAnimationFrame(this.request);
      this.request = null;
    }
    document.getElementById("stopStart").blur();
  }

  keyDownActionHandler(event) {
    switch (event.key) {
      case "ArrowUp":
      case "Up":
        this.ship.moveUp();
        break;
      case "ArrowDown":
      case "Down":
        this.ship.moveDown();
        break;
      case " ":
        this.addShoot();
        break;
     default: return;
   }
   event.preventDefault();
  }

  keyUpActionHandler(event) {
    switch (event.key) {
      case "ArrowUp":
      case "Up":
        if (!this.ship.getDown()) {this.ship.stopMoving();}
        break;
      case "ArrowDown":
      case "Down":
        if (!this.ship.getUp()) {this.ship.stopMoving();}
        break;
     default: return;
   }
   event.preventDefault();
  }

}
/* a la base on a
class Game (au début)
+ ça à la fin

// crée et exporte l'instance unique de Game
const canvas = document.getElementById("terrain");
const theGame = new Game(canvas);
export default theGame;

mais.... euhh.... ça casse tout xd
*/
