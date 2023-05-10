import {marked} from 'marked';

export const metaDataHunter: marked.TokenizerExtension | marked.RendererExtension = {
    name: 'metaDataHunter',
    level: 'inline',
    start(src) {
        return src.match(/%%/)?.index || -1;
    },
    tokenizer(src, tokens) {
        const rule = /%%((?:(?!%%\s).)+)(?:%%\s|$)/g;
        const match = rule.exec(src);
        if (!match) {
            return undefined;
        }

        const token = {
            type: 'metaDataHunter',
            raw: match[0],
            iconLink: match[1],
            tokens: [],
        };
        this.lexer.inline(token.iconLink, token.tokens);
        return token;
    },
    renderer(token) {
        return ''
    },
};
