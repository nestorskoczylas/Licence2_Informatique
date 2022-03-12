import React from 'react';

import "../assets/style/priorityLevel.css"

export default class PriorityLevel extends React.Component {

  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.props.taskPriorityChange(this.props.index+1);
  }

  render() {
    let color = `level ${this.props.color}`;
    return <div className={color} onClick={ this.handleClick }>

    </div>
  }

}
