import {Store} from "./Store.js";

export class ChatListStore extends Store {

    constructor () {
        super();
        this.loadEventName = 'chatListStoreLoaded';
    }

}