import React from 'react';

import Currency from './Currency.jsx'

import "../assets/style/app.css"

import data from '../data/currencies.js';

/*
 define root component
*/
export default class ConvertApp1 extends React.Component {

  constructor(props) {
    super(props);
    this.state = { currencies : [],
                    amount : "0" };
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    this.setState({ currencies : data });
  }

  handleClick() {
    this.setState({ amount : this.refs.newAmount.value });
  }


  render() {
    const allcurrencies = this.state.currencies.map( currencies => <Currency
                                                              amount={ parseFloat(this.state.amount) }
                                                              { ...currencies }
                                                              key={ currencies.code }
                                                        />
                                        );

    return (
      <div className="app">
          <input type="text" placeholder="0" ref="newAmount"/> <label>€</label> <button onClick={ this.handleClick.bind(this) }>OK</button>
          { allcurrencies }
      </div>
    )
  }
//
}
