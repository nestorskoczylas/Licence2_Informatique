import React from 'react';

import "../assets/style/currency.css"

export default class Currency extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    let euro = this.props.amount * this.props.rate;
    if (!this.props.amount > 0) { euro = 0; }
    return (
      <div className="currency">
         { euro.toFixed(2) } { this.props.symbol }
      </div>
    )
  }

}
