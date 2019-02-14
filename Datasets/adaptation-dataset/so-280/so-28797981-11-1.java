public class foo {
    public String readString() throws IOException
    {
        // variable length
        // 00 = empty string
        // 0B <length> <char>* = normal string
        // <length> is encoded as an LEB, and is the byte length of the rest.
        // <char>* is encoded as UTF8, and is the string content.
        byte kind = this.reader.readByte();
        if (kind == 0) return "";
        if (kind != 11)
        {
            throw new IOException(String.format("String format error: Expected 0x0B or 0x00, found 0x%02X", (int) kind & 0xFF));
        }
        int length = readULEB128();
        if (length == 0) return "";
        byte[] utf8bytes = new byte[length];
        this.reader.readFully(utf8bytes);
        return new String(utf8bytes, "UTF-8");
    }
}