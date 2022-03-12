import React from 'react';

import "../assets/style/doneButton.css"

export default class DoneButton extends React.Component {

  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.props.taskDone();
  }

  render() {
    return <div className="doneButton" onClick={ this.handleClick }>
      ✔
    </div>
  }

}
