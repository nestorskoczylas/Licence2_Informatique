import Mobile from './mobile';

import saucerImgSrc from './assets/images/flyingSaucer-petit.png'

export default class Saucer extends Mobile {

  static SAUCER_HEIGHT = 36;
  static SAUCER_WIDTH = 48;

  constructor(x, y, src = saucerImgSrc, deltaX = -3, deltaY = 0) {
    super(x, y, src, deltaX, deltaY);
    this.deleted = false;
    this.fall = false;
  }

  move(canvas) {
    if (this.fall) {
      this.deleted = true;
    }
    else {
      this.x = Math.max(0, this.x + this.deltaX);
      if (this.x === 0) {this.deleted = true;}
    }
  }

}
