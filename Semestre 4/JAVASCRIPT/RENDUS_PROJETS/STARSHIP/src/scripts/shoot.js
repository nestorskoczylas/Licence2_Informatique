import Mobile from './mobile';
import MoveState from "./movestate";
import Saucer from "./saucer";

import shootImgSrc from './assets/images/tir.png';

export default class Shoot extends Mobile {

  constructor(x = 88, y, src = shootImgSrc, deltaX = 8, deltaY = 0) {
    super(x, y, src, deltaX, deltaY);
    this.saucers = [];
    this.deleted = false;
  }

  collisionWith(saucer) {
    let b2x = saucer.x + Saucer.SAUCER_WIDTH;
    let b2y = saucer.y + Saucer.SAUCER_HEIGHT;

    let p1x = Math.max(this.x, saucer.x + 2*Saucer.SAUCER_WIDTH/3);
    let p1y = Math.max(this.y, saucer.y + 2*Saucer.SAUCER_HEIGHT/3);

    let p2x = Math.min(this.x + Saucer.SAUCER_WIDTH, b2x);
    let p2y = Math.min(this.y + Saucer.SAUCER_HEIGHT, b2y);

    return ((p1x < p2x) && (p1y < p2y));
  }

  destroySaucer() {
    let cpt = 0;
    this.saucers.forEach(saucer => {
      if (this.collisionWith(saucer)) {
        saucer.fall = true;
        this.deleted = true;
        cpt ++;
      }
    })
    if (cpt > 0) {return true;}
    return false;
  }

  move(canvas) {
    this.x = Math.max(0, this.x + this.deltaX);
    if (this.x > canvas.width) {this.deleted = true;}
  }

}
