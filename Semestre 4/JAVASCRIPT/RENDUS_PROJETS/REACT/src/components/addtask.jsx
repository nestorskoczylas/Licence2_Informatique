import React from 'react';

import "../assets/style/addtask.css"

export default class AddTask extends React.Component {

  constructor(props) {
    super(props);
    this.state = { description : "Réussir ma L2 info",
                    duration : 9001 };
    this.handleClick = this.handleClick.bind(this);
    this.taskChanged = this.taskChanged.bind(this);
    this.durationChanged = this.durationChanged.bind(this);
  }



  handleClick(event) {
    if (this.state.description != "" && this.state.duration > 0)
      this.createTask();
  }

  taskChanged(newTask) {
    this.setState({ description : this.refs.newTask.value });
  }

  durationChanged(newDuration) {
    this.setState({ duration: this.refs.newDuration.value });
  }

  createTask = () => {
    let theTask = { description : this.state.description,
                    duration : this.state.duration };
    this.props.newTask(theTask);
    this.setState( { description : "" });
  }

  render() {
    return <div className = "addTask">
    <input
       id="adding" ref="newTask" type="text" placeholder="tâche à ajouter" value={ this.state.description } onChange={ this.taskChanged }
    />
    <input
       id="duration" ref="newDuration" type="number" placeholder="0" value={ this.state.duration } onChange={ this.durationChanged }
    />
    mn <button onClick={ this.handleClick }> add </button>
    </div>
  }

}
