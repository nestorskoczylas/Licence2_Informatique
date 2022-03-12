import React from 'react';

import '../assets/style/taskApp.css';

import AddTask from './addtask.jsx';
import Todo from './todo.jsx';
import Done from './done.jsx';
import Task from './task.jsx';

import data from '../data/tasksData.js';

/*
 define root component
*/
export default class TaskApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = { todo : [],
                    done : [] };
    this.addNewTask = this.addNewTask.bind(this);
    this.addTaskDone = this.addTaskDone.bind(this);
    this.taskPriorityChange = this.taskPriorityChange.bind(this);
  }

  componentDidMount() {
    let newTodo = data.map( task => { task.priority = 1; })
    this.setState({ todo : data });
  }

  addNewTask(newTask) {
    newTask.id = `T${ this.state.todo.length + this.state.done.length + 1 }`;
    newTask.priority = 1;
    const newTodo = this.state.todo.concat(newTask);
    this.setState({ todo : newTodo });
  }

  addTaskDone(taskDone) {
    let newTodo = this.state.todo;
    let newDone = this.state.done;

    for(let i = 0; i < newTodo.length; i++) {
      let task = newTodo[i];
      if (task.id == taskDone.id) {
        newDone.push(task);
        newTodo.splice(i, 1);
        i--;
      }
    }

    this.setState({ done : newDone });
    this.setState({ todo : newTodo });
  }

  taskPriorityChange(someTask, newLevel) {
    let newTodo = this.state.todo;
    newTodo.forEach(task => {
      if (task.id == someTask.id) {
        task.priority = newLevel;
      }
    });
    this.setState({ todo : newTodo });
  }

  render() {
    const todo = this.state.todo;
    const done = this.state.done;
    return (
            <div className="taskApp">
            <AddTask
              newTask={ this.addNewTask }
            />

            <Todo
              tasks={ todo }
              taskDone={ this.addTaskDone }
              taskPriorityChange={ this.taskPriorityChange }
            />

            <Done
              tasks={ done }
            />
            </div>
          )
  }
}
