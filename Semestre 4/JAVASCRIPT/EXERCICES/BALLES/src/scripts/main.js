//import Ball from './ball';           // peut être commenté après la Ex1 Q2 faite
import AnimationWithObstacle from './animationWithObstacle';
import Obstacle from './obstacle';

import './assets/style/style-balles.css';

/* setup */
const init = () => {
    const canvas = document.getElementById("terrain");

    //commenter les 2 lignes suivantes après la Ex1 Q2
    //const ball = new Ball(50,50);
    //document.getElementById("stopStartBall").addEventListener("click", () => ball.draw(canvas.getContext('2d'))  );

    //décommenter les deux lignes suivantes à partir la question Ex1 Q4
    const obs = new Obstacle(100, 150, 100, 100);
    const animation = new AnimationWithObstacle(canvas, obs);
    document.getElementById("stopStartBall").addEventListener("click", () => animation.startAndStop());
    document.getElementById("blackhole").addEventListener("click", () => animation.drawObs());
    document.getElementById("addBall").addEventListener("click", () => animation.addBall());
    window.addEventListener('keydown', animation.keyDownActionHandler.bind(animation));
    window.addEventListener('keyup', animation.keyUpActionHandler.bind(animation));
}

window.addEventListener("DOMContentLoaded",init);
console.log('le bundle a été généré');
