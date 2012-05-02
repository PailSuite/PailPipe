/* 
 * Copyright (c) 2012 Chris Bode
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without 
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the 
 * Software, and to permit persons to whom the Software is furnished to do so, subject to the following 
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * No affiliation with PailPipe or any related projects is claimed.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package hafnium.bukkit.pail.util.commands.node;

import hafnium.bukkit.pail.pipe.data.DatumID;
import hafnium.bukkit.pail.util.commands.CommandException;
import hafnium.bukkit.pail.util.commands.ParseArgs;
import hafnium.bukkit.pail.util.text.MessageableException;

public class DatumNode extends CaptureNode {

	public DatumNode() {
		this("data");
	}

	public DatumNode(String type) {
		super(type + " id");
	}

	@Override
	public boolean parse(ParseArgs args) throws MessageableException {
		String token = args.pop();

		if (DatumID.isValid(token)) {
			args.addExecArg(DatumID.getFor(token));
			this.passOn(args);
			return true;
		} else
			// TODO: Explain this better.
			throw new CommandException("^eI could not parse ^u" + token
					+ " ^eas a data id. \nThe proper form is: ^g[[^n<owner>^g](^c@^g|^c.^g)]^n<name>");
	}
}