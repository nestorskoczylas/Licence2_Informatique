import React from 'react';

import PriorityLevel from './prioritylevel.jsx';

import "../assets/style/priorityScale.css"

export default class PriorityScale extends React.Component {

  constructor(props) {
    super(props);
    this.initialLevel = 1;
    this.state = { level : 1 };
    this.nbLevel = 6;
    this.taskPriorityChange = this.taskPriorityChange.bind(this);
  }

  initPrioLevels() {
    let prios = []
    for (let i = 0; i < this.nbLevel; i++) {
      if (i < this.state.level){
        prios.push(<PriorityLevel taskPriorityChange={ this.taskPriorityChange } color="on" index={i} key={i+1}/>)
      }
      else {
        prios.push(<PriorityLevel taskPriorityChange={ this.taskPriorityChange } color="off" index={i} key={i+1}/>)
      }
    }
    return prios;
  }

  taskPriorityChange(newLevel) {
    this.setState({ level : newLevel });
    this.props.taskPriorityChange(newLevel);
  }

  render() {
    let prios = this.initPrioLevels();
    return (
            <div className = "scale">
              { prios }({ this.state.level })
            </div>
            )
  }

}
