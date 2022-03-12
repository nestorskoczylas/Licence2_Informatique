import Mobile from './mobile';
import MoveState from "./movestate";
import Shoot from "./shoot";

import shipImgSrc from './assets/images/vaisseau-ballon-petit.png';

export default class StarShip extends Mobile {

  constructor(x, y, src = shipImgSrc, deltaX = 0, deltaY = 8){
    super(x, y, src, deltaX, deltaY);
    this.moving = MoveState.NONE;
  }

  getUp() {
    return this.moving === MoveState.UP;
  }

  getDown() {
    return this.moving === MoveState.DOWN;
  }

  moveUp() {
    this.deltaY = -Math.abs(this.deltaY);
    this.moving = MoveState.UP;
  }

  moveDown() {
    this.deltaY = Math.abs(this.deltaY);
    this.moving = MoveState.DOWN;
  }

  stopMoving() {
    this.moving = MoveState.NONE;
  }

  move(canvas) {
    if (this.getUp()) {
      this.y = Math.max(0, this.y + this.deltaY);
    }
    if (this.getDown()) {
      this.y = Math.min(canvas.height - this.image.height, this.y + this.deltaY);
    }
  }

}
