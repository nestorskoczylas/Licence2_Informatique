import Game from './game';

import './assets/style/style-saucer.css';

const init = () => {
  const canvas = document.getElementById("stars");
  const game = new Game(canvas);
  game.startAndStop();
  document.getElementById("stopStart").addEventListener("click", () => game.startAndStop());
  document.getElementById("addSaucer").addEventListener("click", () => game.addSaucer());
  document.getElementById("flotteSoucoupes").addEventListener("click", () => game.infinity());
  window.addEventListener('keydown', game.keyDownActionHandler.bind(game));
  window.addEventListener('keyup', game.keyUpActionHandler.bind(game));
}

window.addEventListener("DOMContentLoaded",init);
console.log('le bundle a été généré');
