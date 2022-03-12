import React from 'react';

import PriorityScale from './priorityscale.jsx';
import DoneButton from './donebutton.jsx';

import "../assets/style/task.css"

export default class Task extends React.Component {

  constructor(props) {
    super(props);
    this.taskDone = this.taskDone.bind(this);
    this.taskPriorityChange = this.taskPriorityChange.bind(this);
  }

  taskDone() {
    let theTask = this.props;
    this.props.taskDone(theTask);
  }

  taskPriorityChange(theLevel) {
    this.props.taskPriorityChange(this.props, theLevel);
  }

  render() {
    return (
            <div className = "task">
              { this.props.description }({ this.props.duration }mn)
              <PriorityScale taskPriorityChange={ this.taskPriorityChange }/> <DoneButton taskDone={ this.taskDone }/>
            </div>
            )
  }

}
