import {Component} from "./Component.js";
import {ChatListStore} from "../store/ChatListStore.js";
import {ChatMessages} from "./ChatMessages.js";
import {ChatList} from "./ChatList.js";
import {MessagesStore} from "../store/MessagesStore.js";
import {SendMessageForm} from "./SendMessageForm.js";

export class Chat extends Component {

    constructor (targetElement) {
        super(targetElement);

        this.element.className = 'chat';

        this.chatMessagesPanel = document.createElement('div');
        this.chatMessagesPanel.className = 'chat-messages-panel';

        this.element.appendChild(this.chatMessagesPanel);

        this.chatList = new ChatList(this.element, new ChatListStore());
        this.chatMessages = new ChatMessages(this.chatMessagesPanel, new MessagesStore());
        this.sendMessageForm = new SendMessageForm(this.chatMessagesPanel);

        this.subscribe();
    }

    subscribe () {
        this.chatList.addEventListener('chatSelected', this.onChatSelected.bind(this));
    }

    onChatSelected (event) {
        this.chatMessages.load(event.detail.chatId);
        this.sendMessageForm.chatId = event.detail.chatId;
    }

    loadContent (userInfo) {
        this.render();
        this.chatList.load(userInfo.id);
        this.sendMessageForm.userId = userInfo.id;
    }

    render () {
        this.targetElement.appendChild(this.element);
        this.chatList.render();
        this.chatMessages.render();
        this.sendMessageForm.render();
    }

}