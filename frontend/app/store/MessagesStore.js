import {Store} from "./Store.js";

export class MessagesStore extends Store {

    constructor () {
        super();
        this.loadEventName = 'messagesStoreLoaded';
    }

}