import React from 'react';

import "../assets/style/tasklist.css"

import DoneTask from './donetask.jsx';

export default class Done extends React.Component {

  constructor(props) {
    super(props);
    this.state = { hidden : true };
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    if (this.props.tasks.length > 0) {
      const newHidden = !this.state.hidden;
      this.setState({ hidden : newHidden });
    }
  }

  initializeDoneTasks() {
    if (this.state.hidden === false)
      return this.props.tasks.map( done => <DoneTask { ...done } key={ done.id } /> ) };

  render() {
    let doneAmount = this.props.tasks.length;
    let allTasks = this.initializeDoneTasks();
    let buttonDisplay;
    if (this.state.hidden)
      buttonDisplay= `+${ doneAmount }`;
    else
      buttonDisplay= "cacher";

    return (
            <div className = "tasklist">
            <h3>
              Tâches terminées
              <button onClick={ this.handleClick.bind(this) }> ({ buttonDisplay }) </button>
            </h3>

            { allTasks }

            </div>
          )
  }

}
