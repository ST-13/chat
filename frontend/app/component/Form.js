import {Component} from "./Component.js";

export class Form extends Component {

    constructor (targetElement) {
        super(targetElement, null, 'form');
        this.element.addEventListener('submit', this.onSubmit.bind(this));
    }

    onSubmit (event) {
        event.preventDefault();

        const formSubmitEvent = new CustomEvent('formSubmit', {
            detail: this.getFormData(event.target)
        });

        this.element.dispatchEvent(formSubmitEvent);
    }

    getFormData (formElements) {
        let formData = {};

        Array.from(formElements).forEach((element) => {
            if (element && element.dataset && Object.keys(element.dataset).length) {
                formData[element.dataset.type] = element.value;
            }
        });

        return formData;
    }

}