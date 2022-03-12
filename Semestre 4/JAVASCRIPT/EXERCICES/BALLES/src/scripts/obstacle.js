import MoveState from "./movestate.js";

export default class Obstacle {

  constructor(x, y, width, height) {
    this.x = x;
    this.y = y;
    this.w = width;
    this.h = height;
    this.shiftX = 0;
    this.shiftY = 0;
    this.moving = MoveState.NONE;
  }

  draw(context) {
     context.fillRect(this.x, this.y, this.w, this.h);
  }

  moveLeft() {
    this.shiftX = -10;
    this.moving = MoveState.LEFT;
  }

  moveRight() {
    this.shiftX = 10;
    this.moving = MoveState.RIGHT;
  }

  moveUp() {
    this.shiftY = -10;
    this.moving = MoveState.UP;
  }

  moveDown() {
    this.shiftY = 10;
    this.moving = MoveState.DOWN;
  }

  moveDownRight() {
    this.shiftY = 7;
    this.shiftX = 7;
    this.moving = MoveState.DOWNRIGHT;
  }

  moveDownLeft() {
    this.shiftY = 7;
    this.shiftX = -7;
    this.moving = MoveState.DOWNLEFT;
  }

  moveUpRight() {
    this.shiftY = -7;
    this.shiftX = 7;
    this.moving = MoveState.UPRIGHT;
  }

  moveUpLeft() {
    this.shiftY = -7;
    this.shiftX = -7;
    this.moving = MoveState.UPLEFT;
  }

  stopMoving() {
    this.moving = MoveState.NONE;
  }

  move(box) {
    if (this.moving === MoveState.LEFT) {
      this.x = Math.max(0, this.x + this.shiftX);
    }
    if (this.moving === MoveState.RIGHT) {
      this.x = Math.min(box.width - this.w, this.x + this.shiftX);
    }
    if (this.moving === MoveState.UP) {
      this.y = Math.max(0, this.y + this.shiftY);
    }
    if (this.moving === MoveState.DOWN) {
      this.y = Math.min(box.height - this.h, this.y + this.shiftY);
    }
    if (this.moving === MoveState.DOWNRIGHT) {
      this.y = Math.min(box.height - this.h, this.y + this.shiftY);
      this.x = Math.min(box.width - this.w, this.x + this.shiftX);
    }
    if (this.moving === MoveState.DOWNLEFT) {
      this.y = Math.min(box.height - this.h, this.y + this.shiftY);
      this.x = Math.max(0, this.x + this.shiftX);
    }
    if (this.moving === MoveState.UPRIGHT) {
      this.y = Math.max(0, this.y + this.shiftY);
      this.x = Math.min(box.width - this.w, this.x + this.shiftX);
    }
    if (this.moving === MoveState.UPLEFT) {
      this.y = Math.max(0, this.y + this.shiftY);
      this.x = Math.max(0, this.x + this.shiftX);
    }
  }

}
