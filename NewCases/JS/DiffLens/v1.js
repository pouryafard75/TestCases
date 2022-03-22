import './App.css';
import React from 'react';
import { Component } from 'react';
import 'bulma/css/bulma.min.css';
import HeaderContainer from './HeaderContainer';

function onChange(newValue) {
    console.log("change", newValue);
}
class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dropdownSelectedOption: null,
        }
    }

    _setElementHeights() {
        let containerWrapper = document.getElementById("containerWrapper");
        let oracle = document.getElementById("oracle");
        let gutter = document.getElementById("gutter");
        let elf = document.getElementById("elf");
        setHeight(containerWrapper);
        setHeight(oracle);
        setHeight(gutter);
        setHeight(elf);
    }
    
    setHeight(el) {
        if (el) {
            el.style.height = (window.innerHeight - 38).toString();;
        }
    }

    componentDidMount() {
        this.setState({
            dropdownSelectedOption: this.props.dropdownValueAndLabels[0],
        });
    }

    handleDropdownClick(newValue) {
        var index = this.props.handleDropdownClick(newValue);
        if (index) {
            this.setState({
                dropdownSelectedOption: this.props.dropdownValueAndLabels[index],
            });
        }
    }
    render() {
        const winner = calculateWinner(this.state.squares);
        let status;
        if (winner) {
          status = 'Winner: ' + winner;
        } else {
          status = 'Next player: ' + (this.state.xIsNext ? 'X' : 'O');
        }
    
        return (
          <div>
            <div className="status">{status}</div>
            <div className="board-row">
              {this.renderSquare(0)}
              {this.renderSquare(1)}
              {this.renderSquare(2)}
            </div>
            <div className="board-row">
              {this.renderSquare(3)}
              {this.renderSquare(4)}
              {this.renderSquare(5)}
            </div>
            <div className="board-row">
              {this.renderSquare(6)}
              {this.renderSquare(7)}
              {this.renderSquare(8)}
            </div>
          </div>
        );
    }
}
export default App;
