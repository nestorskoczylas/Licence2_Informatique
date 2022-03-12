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
                    amount : "1" };
  }

  componentDidMount() {
    this.setState({ currencies : data });
  }

  numberValueChanged(event) {
    this.setState({ amount : event.target.value });
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
          <input type="text" placeholder="0" value={ this.state.amount } onChange={ this.numberValueChanged.bind(this) }/> <label>€</label>
          { allcurrencies }
      </div>
    )
  }
//
}
