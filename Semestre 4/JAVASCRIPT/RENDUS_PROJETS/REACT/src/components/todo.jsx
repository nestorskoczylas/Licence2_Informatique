import React from 'react';

import Task from './task.jsx';

import "../assets/style/tasklist.css"

export default class Todo extends React.Component {

  constructor(props) {
    super(props);
    this.taskDone = this.taskDone.bind(this);
    this.taskPriorityChange = this.taskPriorityChange.bind(this);
    this.state = { filter : "" };
    this.filterChanged = this.filterChanged.bind(this);
  }

  filterChanged(event) {
    this.setState({ filter : event.target.value });
  }

  initializeTodoTasks() {
    let filterVal = this.state.filter;
    let allTasks = this.props.tasks.filter(todo => todo.description.toLowerCase()
                                    .includes(filterVal.toLowerCase()))
                                    .map( todo => <Task
                                                    taskDone={ this.props.taskDone }
                                                    taskPriorityChange={ this.props.taskPriorityChange }
                                                    { ...todo }
                                                    key={ todo.id }
                                                />
                                        );
    allTasks.sort((a, b) => (a.props.priority < b.props.priority) ? 1 : -1);
    return allTasks;
  }

  taskDone(someTask) {
    this.props.taskDone(someTask);
  }

  taskPriorityChange(someTask, newLevel) {
    this.props.taskPriorityChange(someTask, newLevel);
  }

  render() {
    let allTasks = this.initializeTodoTasks();
    let taskAmount = allTasks.length;

    let timeRemaining = 0;
    allTasks.forEach(task => { timeRemaining += parseInt(task.props.duration); });

    let taskDisplay = "tâche";
    if (taskAmount > 1) { taskDisplay+='s'; }

    return (
            <div className = "tasklist">

              <h3>
                Tâches en cours
              </h3>
              <input
                 id="filtre" type="text" placeholder="filtre"
                 value= { this.filter }
                 onChange = { this.filterChanged }
              />
              <div>
                Il y a { taskAmount } { taskDisplay } en cours.
                Pour une durée de { timeRemaining } mn.
              </div>
              { allTasks }

            </div>
          )
  }

}
