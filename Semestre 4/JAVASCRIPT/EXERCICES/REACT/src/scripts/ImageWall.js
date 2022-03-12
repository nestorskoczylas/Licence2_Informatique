import ReactDOM from 'react-dom';

export default class ImageWall extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    const patrick = this.props.images.filter(img =>
        img.texte.toLowerCase().includes(this.props.filterText.toLowerCase()))
      .map(img =>
        <img alt={img.texte}
        src={img.image}
        onMouseOver = {() => this.props.imageChanged(img.image, img.texte)}
        key={img.image}/>
    );
    return <div id ="mur">{patrick}</div>;
  }

}
