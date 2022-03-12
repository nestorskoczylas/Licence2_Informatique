import Mobile from './mobile';

import saucerImgSrc from './assets/images/flyingSaucer-petit.png'

export default class SaucerFalling extends Mobile {

  constructor(x, y, src = saucerImgSrc, deltaX = 0, deltaY = 3) {
    super(x, y, src, deltaX, deltaY);
    this.deleted = false;
  }

  move(canvas) {
    this.y = Math.min(canvas.height, this.y + this.deltaY);
    if (this.y === canvas.height) {this.deleted = true;}
  }

}
