import './App.css';
import React from 'react';
import { Component } from 'react';
import 'bulma/css/bulma.min.css';
import HeaderContainer from './HeaderContainer';
const proto = require('./globalMessages_pb');
const axios = require('axios').default;

function onChange(newValue) {
    console.log("change", newValue);
}
class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedOption: null,
            groupedOptions: props.dropdownValueAndLabels,
            loading: false,
        }

        this.filenames = new Map()
        for (let i = 0; i < props.dropdownValueAndLabels[0].options.length; i++) {
            this.filenames.set(props.dropdownValueAndLabels[0].options[i].value, props.dropdownValueAndLabels[0].options[i]);
        }

        this.originalCommitOptions = props.dropdownValueAndLabels[1].options;
    }

    render() {
        return (
            <div>
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

    handleDropdownClick(newValue) {
        let value = newValue.value;
        if (this.filenames.has(value)) {
            let setValue = this.filenames.get(value);
            // Filename
            this.setState((state, props) => ({
                selectedOption: setValue,
            }));
            this.props.handleFileClick(value);
        } else {
            // Commit
            let split = value.split(' ');
            let commitSha = split[split.length - 1];
            let newCommitOptions = this._getCommitOptionsForSelectCommit(value);
            let localGroupedOptions = [
                {
                    label: 'Option 1',
                    options: this.state.groupedOptions[0].options,
                },
                {
                    label: 'Option 2',
                    options: newCommitOptions,
                },
            ]
            this.setState({
                loading: true,
                groupedOptions: localGroupedOptions
            })
            axios.get(`route/api`,
                {
                    responseType: 'arraybuffer'
                }).then(get => {
                    let buffer = get.data;
                    let contents = new Uint8Array(buffer);
                    let diffs = proto.ProtoArrayOfFilenameAndDiff.deserializeBinary(contents);
                    let arrayOfProtoFilenameAndDiff = diffs.getFilenameandList();
                    let firstFile = this._populateDropdownValueAndLabelsFromProto(arrayOfProtoFilenameAndDiff);
                    this.props.handleClick(arrayOfProtoFilenameAndDiff, firstFile);
                    this.setState({
                        loading: false,
                    })
                });
        }
    }

    _populateDropdownValueAndLabelsFromProto(arrayOfProtoFilenameAndDiff) {
        let localFilenameOptions = [];
        let firstFile = "";
        for (let i = 0; i < arrayOfProtoFilenameAndDiff.length; i++) {
            let protoFilenameAndDiff = arrayOfProtoFilenameAndDiff[i];
            let protoFilenameAndDiffObject = protoFilenameAndDiff.toObject();
            localFilenameOptions.push({ value: protoFilenameAndDiffObject.filename, label: protoFilenameAndDiffObject.filename });
            if (i === 0) {
                firstFile = protoFilenameAndDiffObject.filename;
            }
        }

        let cachedCommitOptions = this.state.groupedOptions[1].options;
        let localGroupedOptions = [
            {
                label: 'Option 1',
                options: localFilenameOptions,
            },
            {
                label: 'Option 2',
                options: cachedCommitOptions,
            },
        ]
        this.setState({
            selectedOption: localFilenameOptions[0],
            groupedOptions: localGroupedOptions
        });

        return firstFile;
    }

    componentDidMount() {
        this.setState({
            selectedOption: this.props.dropdownValueAndLabels[0].options[0],
            groupedOptions: this.props.dropdownValueAndLabels,
            loading: false,
        });
    }

    _getCommitOptionsForSelectCommit(value) {
        let commitOptions = [];
        for (let i = 0; i < this.originalCommitOptions.length; i++) {
            if (this.originalCommitOptions[i].value === value) {
                commitOptions.push({ value: "* " + value, label: "* " + value, color: '#666666' })
            } else {
                commitOptions.push({ value: this.originalCommitOptions[i].value, label: this.originalCommitOptions[i].value, color: '#666666' })
            }
        }

        return commitOptions;
    }

    setHeight(el) {
        if (el) {
            el.style.height = (window.innerHeight - 38).toString();;
        }
    }

    deleteVirtual(isUp) {
        if (isUp) {
            if (this._upWidget) {
                var session = this._getUpSession();
                session.widgetManager.removeWidget(this._upWidget);
                this._upWidget = null;
            }
        } else {
            if (this._downWidget) {
                var session = this._getSession();
                session.widgetManager.removeWidget(this._downWidget);
                this._downWidget = null;
            }
        }
    }
}
export default App;