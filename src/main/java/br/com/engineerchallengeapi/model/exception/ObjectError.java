package br.com.engineerchallengeapi.model.exception;

public class ObjectError {
    private String code;
    private String message;
    private String nativeMessage;
    
    public ObjectError() {}

    public ObjectError(String code, String message, String nativeMessage) {
        this.code = code;
        this.message = message;
        this.nativeMessage = nativeMessage;
    }

    public String getCode() {
        return code;
    }

    public String getNativeMessage() {
        return nativeMessage;
    }

    public void setNativeMessage(String nativeMessage) {
        this.nativeMessage = nativeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((nativeMessage == null) ? 0 : nativeMessage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObjectError other = (ObjectError) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (nativeMessage == null) {
            if (other.nativeMessage != null)
                return false;
        } else if (!nativeMessage.equals(other.nativeMessage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Error [code=" + code + ", message=" + message + ", nativeMessage=" + nativeMessage + "]";
    }
}